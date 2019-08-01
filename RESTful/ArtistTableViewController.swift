import UIKit
import Dispatch

class ArtistTableViewController: UITableViewController {
    
    @IBOutlet var CoursesTableView: UITableView!
    
    var  artists = [Artist]()
    
    override func viewDidLoad() {
        super.viewDidLoad()
        artists.removeAll()
        getAllCourses()
    }


    override func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return artists.count
    }

    
    override func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = tableView.dequeueReusableCell(withIdentifier: "CourseTableViewCell") as! ArtistTableViewCell
            cell.name.text = artists[indexPath.row].name
            cell.number.text = String(artists[indexPath.row].followers)
            return cell
    }
    
    func getAllCourses() -> [Artist]{
            //decoder to read json and create objects
            let decoder = JSONDecoder()
            let url = URL(string: "http://localhost:8080/artists")
            let task = URLSession.shared.dataTask(with: url!) { (data, response, error) in
                if let data = data {
                    do {
                        let jsoncourses = try decoder.decode([Artist].self, from: data)
                        self.artists = jsoncourses
                        print(jsoncourses)
                        // Update UI in main thread
                        DispatchQueue.main.async {
                            self.CoursesTableView.reloadData()
                        }
                    } catch {
                        print(error.localizedDescription)
                    }
                }
            }
        task.resume()
        //print(artists)
        return artists
        
    }
}

