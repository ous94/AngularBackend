import { Injectable } from '@angular/core';
//pour les service
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { Customer } from './customer';
import { catchError, map, tap } from 'rxjs/operators';




@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  private heroesUrl = 'http://localhost:4201/api/customers';  // URL to web api
  console: any;

  constructor( private http: HttpClient,
    private CustomerService: CustomerService) { }

    //recuperations de customers
    getHeroes(): Observable<Customer[]> {
      return this.http.get<Customer[]>(this.heroesUrl)
    .pipe(
      tap(_ => this.console.log('fetched heroes')),      
      catchError(this.handleError('getHeroes', []))
    );
}
  handleError(arg0: string, arg1: undefined[]): (err: any, caught: Observable<Customer[]>) => never {
    throw new Error("Method not implemented.");
  }

  /** GET hero by id. Will 404 if id not found */
getHero(id: number): Observable<Customer> {
  const url = `${this.heroesUrl}/${id}`;
  return this.http.get<Customer>(url).pipe(
    tap(_ => this.console.log(`fetched hero id=${id}`)),
    //catchError(this.handleError<Customer>(`getHero id=${id}`))
  );
}
}
