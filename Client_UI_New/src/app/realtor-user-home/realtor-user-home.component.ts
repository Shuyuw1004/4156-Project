import {Component, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-realtor-user-home',
  templateUrl: './realtor-user-home.component.html',
  styleUrls: ['./realtor-user-home.component.css']
})
export class RealtorUserHomeComponent implements OnInit {

  constructor(private httpClient: HttpClient, private route: ActivatedRoute) { }

  ngOnInit(): void {
  }

  getTenants() {
    let url = "http://127.0.0.1:8080/realtor/getTenants";

  }

}
