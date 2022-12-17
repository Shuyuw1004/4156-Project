import {Component, OnInit} from '@angular/core';
import {HttpClient, HttpParams} from "@angular/common/http";
import {Router} from "@angular/router";

@Component({
  selector: 'app-landlord-signin',
  templateUrl: './landlord-signin.component.html',
  styleUrls: ['./landlord-signin.component.css']
})
export class LandlordSigninComponent implements OnInit {

  showLog: boolean = false;
  ErrorLog :string = "";
  constructor(private httpClient: HttpClient, private router: Router) { }

  ngOnInit(): void {
  }
  onSignin(name:string, password:string, email:string) {
    let url1 = "http://127.0.0.1:8080/client/login";
    let params1 = new HttpParams()
      .append("name", name)
      .append("password", password)
      .append("email", email);
    this.httpClient.post(url1,"",{params: params1, observe: 'body', responseType: 'text'}).subscribe(
      (data:string) => {
        if (data.includes("landlord")) {
          this.ErrorLog = "signin successful!";
          this.router.navigate(
            ['/landlordUserHome'],
            {
              queryParams: {"name": name, "email": email, "clientId": data.split("|")[0]}
            }
          );
        } else {
          this.ErrorLog = "You are not a landlord!"
        }
      },
      error => this.ErrorLog = error.error);
    this.showLog = true;
    return false;
  }

}
