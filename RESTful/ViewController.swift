import UIKit

class ViewController: UIViewController {
    
    var artists = [Artist]()
    

    @IBOutlet weak var name: UITextField!
    
    @IBOutlet weak var number: UITextField!
    
    @IBOutlet weak var containerView: UIView!
    
    override func viewDidLoad() {
        super.viewDidLoad()
    }
    
    @IBAction func getAllCourses(_sender: UIButton){
        //self.performSegue(withIdentifier: "showCourses", sender: self)
        }
    
    @IBAction func createArtist(_sender: UIButton){
        var artist = [String: Any]()
        artist["name"] = name.text!
        artist["followers"] = Int(number.text!)
        let url = URL(string: "http://localhost:8080/artists")
        var request = URLRequest(url: url!)
        request.setValue("application/json;charset=UTF-8", forHTTPHeaderField: "Content-Type")
        request.httpMethod = "POST"
        guard let body = try? JSONSerialization.data(withJSONObject: artist, options: []) else {
            return
        }
        let alert = UIAlertController(title: "Success", message: "Artist Saved!", preferredStyle: .alert)
        alert.addAction(UIAlertAction(title: "Ok", style: .default))
        self.present(alert, animated: true)
        request.httpBody = body
        let task = URLSession.shared.dataTask(with: request) { (data, response, error) in
            if let response = response {
                print(response)
            }
            if let data = data {
                do {
                    let jsonSerialized = try JSONSerialization.jsonObject(with: data, options: []) as? [String: Any]
                    if let json = jsonSerialized {
                        print(json)
                    }
                } catch let error as NSError {
                    print(error.localizedDescription)
                }
            } else if let error = error {
                print(error.localizedDescription)
            }
        }
        task.resume()
   }
}


