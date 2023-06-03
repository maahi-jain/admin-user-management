import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Admin } from '../Models/Admin';
import { LoginService } from '../service/login.service';
import { Router } from '@angular/router';
import { AuthServiceService } from '../service/auth-service.service';

@Component({
  selector: 'app-user-login',
  templateUrl: './user-login.component.html',
  styleUrls: ['./user-login.component.scss']
})
export class UserLoginComponent implements OnInit {
  loginForm!: FormGroup;
  errorMessage!: string;
  admin!: Admin;
  constructor(private fb: FormBuilder, private loginService: LoginService, private router: Router, private auth: AuthServiceService) { }

  ngOnInit(): void {
    this.loginForm = this.fb.group(
      {
        userName: ['', [Validators.required, Validators.maxLength(15)]],
        password: ['', [Validators.required, Validators.minLength(8)]]
      }
    )
  }

  login() {
    // console.log(this.loginForm.value)
    this.loginService.login(this.loginForm.value).subscribe(
      (response) => {
        this.errorMessage = ""
        this.admin = response
        this.auth.nextUser(this.admin)
        this.router.navigate(["/userDetails"])
      },
      (error) => {
        this.errorMessage = error.error.message
      })
  }
}
