import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class TokenService {
  handle(access_token: any) {
    throw new Error('Method not implemented.');
  }

  constructor() { }
}
