import { Injectable } from "@angular/core";


@Injectable({
    providedIn: 'root'
})
export class DateProcessor {

    public formatDate(date: Date): string {
        const options: Intl.DateTimeFormatOptions = {
          day: '2-digit',
          month: 'short',
          year: 'numeric'
        };
      
        const formattedDate = new Intl.DateTimeFormat('en-US', options).format(date);
        return formattedDate;
    }

}