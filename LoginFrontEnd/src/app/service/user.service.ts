import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http:HttpClient) { }

  deleteUser(data:any): Observable<any>{
    console.log(data)
    const options={headers:new HttpHeaders({
      'Content-Type':'application/json',}),
      body:data}
    return <Observable<any>>this.http.delete(environment.deleteUser, options);
  }

  addUser(data:any):Observable<any>{
    return <Observable<any>>this.http.post(environment.addUser, data);
  }

}
