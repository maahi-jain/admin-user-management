import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { RegisterService } from '../service/register.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {

  registerForm!: FormGroup;
  successMessage: string = "";
  errorMessage: string = ""
  constructor(private formBuilder: FormBuilder, private registerService: RegisterService) { }

  ngOnInit(): void {
    this.registerForm = this.formBuilder.group({
      userName: ['', [Validators.required, Validators.maxLength(15)]],
      password: ['', [Validators.required, Validators.minLength(8), Validators.pattern('.*[A-z].*'), Validators.pattern('.*[0-9].*'), Validators.pattern('.*[@!$#%&].*')]],
      name: ['', Validators.required],
      contactNumber: ['', [Validators.required, Validators.pattern('[0-9]{10}')]],
      emailId: ['', Validators.required],
      dob: ['', Validators.required]
    })
  }

  register() {
    this.registerService.register(this.registerForm.value).subscribe({
      next: (response) => {
        this.errorMessage = "";
        this.successMessage = response.message;
      },
      error: (error) => {
        this.successMessage = "";
        this.errorMessage = error.error.message;
      }
    }
    )
  }

}
