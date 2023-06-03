import { Component, OnInit } from '@angular/core';
import { LoginService } from '../service/login.service';
import { Admin } from '../Models/Admin';
import { AuthServiceService } from '../service/auth-service.service';
import { UserService } from '../service/user.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import {MatDialog} from '@angular/material/dialog';
import { NewUserComponent } from '../new-user/new-user.component';

@Component({
  selector: 'app-user-details',
  templateUrl: './user-details.component.html',
  styleUrls: ['./user-details.component.scss']
})
export class UserDetailsComponent implements OnInit {

  admin!: Admin;
  empNo!: number;
  successMessage!: string;
  errorMessage!: string;
  newUser!: FormGroup;
  register: boolean = false;
  displayedColumns: string[] = ['employeeNo', 'name', 'emailId', 'contactNumber','action'];

  constructor(private auth: AuthServiceService, private userService: UserService, private fb: FormBuilder, private loginService: LoginService, private dialog: MatDialog) {
  }
  ngOnInit(): void {
    this.auth.sessionUser.subscribe(data => {
      this.admin = data;
    })

    this.newUser = this.fb.group(
      {
        name: ['', Validators.required],
        emailId: ['', Validators.required],
        contactNumber: ['', [Validators.required, Validators.pattern('[0-9]{10}')]],
        admin: [this.admin]
      }
    )
  }

  userRegister(): void {
   const user=this.dialog.open(NewUserComponent);
   user.afterClosed().subscribe(
    {
      next: (success) => {
        this.errorMessage = "";
        this.successMessage = success.message;
        this.refresh();
      },
      error: (error) => {
        this.successMessage = "";
        this.errorMessage = error.error.message;
      }
    }
  )
  }

  deleteUser(user: any): void {
    this.userService.deleteUser(user.empNo).subscribe(
      {
        next: (success) => {
          this.errorMessage = "";
          this.successMessage = success.message;
          this.refresh();
        },
        error: (error) => {
          this.successMessage = "";
          this.errorMessage = error.error.message;
        }
      }
    )
  }

  addUser(): void {
    this.userService.addUser(this.newUser.value).subscribe(
      (success) => {
        this.errorMessage = "";
        this.successMessage = success.message;
        this.refresh();
        this.register = false;
      },
      (error) => {
        this.successMessage = "";
        this.errorMessage = error.error.message
      });
  }

  refresh(): void {
    this.loginService.login(this.admin).subscribe(
      (response) => { this.admin = response }
    )

  }

}
