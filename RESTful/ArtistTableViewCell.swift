
import UIKit

class ArtistTableViewCell: UITableViewCell {


    @IBOutlet var name: UILabel!
    
    @IBOutlet var number: UILabel!
    
    
    override func awakeFromNib() {
        super.awakeFromNib()
        // Initialization code
    }

    override func setSelected(_ selected: Bool, animated: Bool) {
        super.setSelected(selected, animated: animated)

        // Configure the view for the selected state
    }
}
