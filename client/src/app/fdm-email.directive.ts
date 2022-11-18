import { Directive } from '@angular/core';
import { AbstractControl, Validator, NG_VALIDATORS  } from '@angular/forms';

@Directive({
  selector: '[appFdmEmail]',
  providers: [{
    provide: NG_VALIDATORS,
    useExisting: FdmEmailDirective,
    multi: true
  }]
})
export class FdmEmailDirective implements Validator{

  constructor() { }
  validate(control: AbstractControl): {[key: string]: any} | null {

    if (control.value.match('^.*@fdmgroup\.com$')) {
      return { 'notFdmEmail' : false };
    } else {
      return { 'notFdmEmail' : true };
    }

  }

  

}
