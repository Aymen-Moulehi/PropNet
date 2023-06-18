import { Injectable } from "@angular/core";

@Injectable({
  providedIn: 'root'
})
export class StringProcessor {

    public reverseString(inputString: string): string {
      return inputString.split('').reverse().join('');
    }
  
    public capitalizeString(inputString: string): string {
      return inputString.toUpperCase();
    }

    public extractWordList(inputString: string): string[] {
      // Remove punctuation and special characters, and convert the string to lowercase
      const cleanedString = inputString.replace(/[^\w\s]|_/g, '').toLowerCase();
    
      // Split the cleaned string into an array of words
      const wordList = cleanedString.split(/\s+/);
    
      // Capitalize the first letter of each word
      const capitalizedWordList = wordList.map((word) => {
        return word.charAt(0).toUpperCase() + word.slice(1);
      });
    
      return capitalizedWordList;
    }

  }