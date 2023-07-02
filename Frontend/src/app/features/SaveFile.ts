import {Injectable} from "@angular/core";

@Injectable({
  providedIn: 'root'
})
export class SaveFile {
    save(data: ArrayBuffer, filename: string): void {
        const blob = new Blob([data], { type: 'application/pdf' });
        const url = window.URL.createObjectURL(blob);
        const a = document.createElement('a');
        a.href = url;
        a.download = filename;
        a.click();
        window.URL.revokeObjectURL(url);
    }
}
