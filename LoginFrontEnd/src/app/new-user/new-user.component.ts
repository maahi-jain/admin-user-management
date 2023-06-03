import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Admin } from '../Models/Admin';
import { AuthServiceService } from '../service/auth-service.service';
import { LoginService } from '../service/login.service';
import { UserService } from '../service/user.service';
import {MatDialogRef, MAT_DIALOG_DATA, MatDialog } from '@angular/material/dialog';

@Component({
  selector: 'app-new-user',
  templateUrl: './new-user.component.html',
  styleUrls: ['./new-user.component.scss']
})
export class NewUserComponent {

  admin!: Admin;
  newUser!: FormGroup;

  constructor(private auth: AuthServiceService, private userService: UserService, private fb: FormBuilder, private loginService: LoginService, public dialogRef:MatDialogRef<any>) {
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

  addUser(): void {
    this.userService.addUser(this.newUser.value).subscribe({
      next: (success) => {
       this.dialogRef.close(success);
      },
      error: (error) => {
        this.dialogRef.close(error);
      }
    })
  }

}
