import { TestBed } from '@angular/core/testing';

import { CustomerdetailsService } from './customerdetails.service';

describe('CustomerdetailsService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: CustomerdetailsService = TestBed.get(CustomerdetailsService);
    expect(service).toBeTruthy();
  });
});
