
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import {HttpClient, HttpParams} from "@angular/common/http";
@Component({
  selector: 'app-userhome',
  templateUrl: './user-home.component.html',
  styleUrls: ['./user-home.component.css']
})
export class UserHomeComponent implements OnInit {
  name :string = "";
  email : string = "";
  clientId : string = '';

  constructor(private httpClient: HttpClient, private route: ActivatedRoute) { }

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
        let temp_clientId = params.get('clientId');
        if ( temp_clientId !== null){
          this.clientId = temp_clientId;
        } else {
          this.clientId = "";
        }
        }
      );
  }
  getMatch() {
    let url = "http://127.0.0.1:8080/tenant/getMatch";
    let params = new HttpParams()
      .append("tClientId", this.clientId);
    this.httpClient.get(url,{params: params}).subscribe({
      next: next => console.log("Success!", next),
      error: error => console.log("Error!", error)
    });
  }

}
