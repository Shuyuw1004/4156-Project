
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
@Component({
  selector: 'app-userhome',
  templateUrl: './user-home.component.html',
  styleUrls: ['./user-home.component.css']
})
export class UserHomeComponent implements OnInit {
  name :string = "";
  email : string = "";

  constructor(private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.route.queryParamMap
      .subscribe((params) => {
        let temp_name = params.get('name');
        if ( temp_name !== null){
          this.name = temp_name;
        } else {
          this.name = "";
        }
        let temp_email = params.get('email');
        if ( temp_email !== null){
          this.email = temp_email;
        } else {
          this.email = "";
        }
        console.log(this.name);
        console.log(this.email);

        }
      );
  }
  getMatch() {

  }

}
