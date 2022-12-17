import {Component, OnInit} from '@angular/core';
import {HttpClient, HttpParams} from "@angular/common/http";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-landlord-user-home',
  templateUrl: './landlord-user-home.component.html',
  styleUrls: ['./landlord-user-home.component.css']
})
export class LandlordUserHomeComponent implements OnInit {
  name :string = "";
  email : string = "";
  clientId : string = '';
  getZipcodeResponse : string = "";
  getTenantsByZipcode : string = "";

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

  getZipcode() {
    let url = "http://127.0.0.1:8080/client/getZipcode";
    let url2 = "http://127.0.0.1:8080/client/getTenantByZipcode";
    this.httpClient.get(url,{observe: 'body', responseType: "text"}).subscribe({
      next: next => {
        console.log(next);
        this.getZipcodeResponse = next.toString();
        let params = new HttpParams()
          .append("zipcode", this.getZipcodeResponse);
        this.httpClient.get(url2, {params: params, observe: 'body', responseType: "text"}).subscribe(
          {
            next: next => {
            this.getTenantsByZipcode = next;
            },
            error: error => {
              console.log(error);
              this.getTenantsByZipcode = error.error;
            }
          }
        );
      },
      error: error => {
        console.log(error);
        this.getZipcodeResponse = error.error;
      }
    });

  }

}
