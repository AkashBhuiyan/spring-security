import { Component, OnInit } from '@angular/core';
import { Contact } from "src/app/model/contact.model";
import { NgForm } from '@angular/forms';
import { getCookie } from 'typescript-cookie';
import { DashboardService } from 'src/app/services/dashboard/dashboard.service';


@Component({
  selector: 'app-contact',
  templateUrl: './contact.component.html',
  styleUrls: ['./contact.component.css']
})
export class ContactComponent implements OnInit {
  model = new Contact();
  contactList = new Array<Contact>();

  constructor(private dashboardService: DashboardService) {

  }

  ngOnInit() {

  }

  saveMessage(contactForm: NgForm) {
    this.dashboardService.saveMessage(this.model).subscribe(
      responseData => {
        this.contactList = <any> responseData.body;
        this.contactList.forEach(function (this: ContactComponent, contact: Contact) {
          this.model = contact;
        }.bind(this));
        contactForm.resetForm();
      });

  }

}
