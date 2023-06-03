import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { Admin } from '../Models/Admin';

@Injectable({
  providedIn: 'root'
})
export class AuthServiceService {

  sessionUser: BehaviorSubject<Admin> = new BehaviorSubject<Admin>(new Admin());
  admin!: Admin;
  constructor(private http: HttpClient) {
    this.loadSessionUser();
  }
  loadSessionUser() {
    this.admin = new Admin();
    this.admin.userName = "";
  }
  nextUser(data: Admin) {
    this.admin = data;
    this.sessionUser.next(this.admin);

  }
}
