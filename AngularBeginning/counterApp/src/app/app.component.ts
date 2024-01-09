import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'counterApp';
  countNumber = 0;

    resetBtn(){
      this.countNumber = 0;
    }
    
    incBtn(){
      if(this.countNumber<10){
        this.countNumber++;
        
      }

    }

    decBtn(){
      if(this.countNumber>=1){
         this.countNumber--;
      }
    }
}
