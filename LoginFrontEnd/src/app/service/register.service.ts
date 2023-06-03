import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Admin } from '../Models/Admin';

@Injectable({
  providedIn: 'root'
})
export class RegisterService {

  constructor(private http:HttpClient) { }

  register(data:any): Observable<any>{
    return <Observable<any>>this.http.post<Admin>(environment.register, data);
  }
}
