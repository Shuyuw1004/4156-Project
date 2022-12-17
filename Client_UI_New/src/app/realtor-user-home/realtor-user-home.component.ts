import {Component, OnInit} from '@angular/core';
import {HttpClient, HttpParams} from "@angular/common/http";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-realtor-user-home',
  templateUrl: './realtor-user-home.component.html',
  styleUrls: ['./realtor-user-home.component.css']
})
export class RealtorUserHomeComponent implements OnInit {

  name : string = "";
  email : string = "";
  clientId : string = "";
  getTenantsResponse : string = "";
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

  getTenants() {
    let url = "http://127.0.0.1:8080/client/getTenantByZipcode";
    let zipcode = (<HTMLInputElement>document.querySelector('[name="zipcode"]')).value;
    let params = new HttpParams()
      .append("zipcode", zipcode);
    this.httpClient.get(url,{params: params, observe: 'body', responseType: "text"}).subscribe({
      next: next => {
        console.log(next);
        this.getTenantsResponse = next.toString();
      },
      error: error => {
        console.log(error);
        this.getTenantsResponse = error.error;
      }
    });
    return false;


  }

}
