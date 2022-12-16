import {Component, OnInit} from '@angular/core';
import {HttpClient, HttpParams} from "@angular/common/http";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-landlord-user-home',
  templateUrl: './landlord-user-home.component.html',
  styleUrls: ['./landlord-user-home.component.css']
})
export class LandlordUserHomeComponent implements OnInit {



  constructor(private httpClient: HttpClient, private route: ActivatedRoute) { }

  ngOnInit(): void {
  }

  getZipcode() {
    let url = "http://127.0.0.1:8080/landlord/getZipcode";

  }

}
