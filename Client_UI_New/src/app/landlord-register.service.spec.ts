import { TestBed } from '@angular/core/testing';

import { LandlordRegisterService } from './landlord-register.service';

describe('LandlordRegisterService', () => {
  let service: LandlordRegisterService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(LandlordRegisterService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
