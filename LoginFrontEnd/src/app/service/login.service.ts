import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Admin } from '../Models/Admin';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private http: HttpClient) { }
  
  login(data:any) : Observable<any>
  {
    return <Observable<any>>this.http.post<Admin>(environment.loginUri, data)
  }



}
