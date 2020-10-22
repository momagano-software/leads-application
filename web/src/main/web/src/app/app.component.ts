import { Component, OnInit } from '@angular/core';
import { HomeControllerService } from './api/services'

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'dummy-ui';

  constructor( private homeControllerService: HomeControllerService ) {

  }

  ngOnInit() {
       this.homeControllerService.getSomething().subscribe( res => {
        console.log(res);
       }, e => {
        console.table(e);
       });
     }
}
