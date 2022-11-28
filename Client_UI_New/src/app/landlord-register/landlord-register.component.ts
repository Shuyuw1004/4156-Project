import { Component, OnInit } from '@angular/core';
import {HttpClient, HttpParams} from "@angular/common/http";
import { Landlord } from './landlord';

@Component({
  selector: 'app-landlord-register',
  templateUrl: './landlord-register.component.html',
  styleUrls: ['./landlord-register.component.css']
})
export class LandlordRegisterComponent implements OnInit {

  public landlord: Landlord;

  constructor(private httpClient: HttpClient) {
    this.landlord = new Landlord("123", "123456", "123@columbia1.edu", "123456789");
  }

  ngOnInit(): void {
  }

  onRegister() {
    let url1 = "http://127.0.0.1:8080/client/register";
    let url2 = "http://127.0.0.1:8080/landlord/insertLandlord";
    let params = new HttpParams()
                      .append("name", this.landlord.name)
                      .append("password", this.landlord.password)
                      .append("email", this.landlord.email)
                      .append("phone", this.landlord.phone);
    console.log("Register");
    this.httpClient.post(url1,"",{params: params}).subscribe({
      next: next => console.log("Success!", next),
      error: error => console.log("Error!", error)
    });
    this.httpClient.post(url2, "",{params: params}).subscribe({
      next: next => console.log("Success!", next),
      error: error => console.log("Error!", error)
    });
    for(;;){

    }
  }
}
