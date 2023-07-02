import { TestBed } from '@angular/core/testing';

import { RealEstateListingService } from './real-estate-listing.service';

describe('RealEstateListingService', () => {
  let service: RealEstateListingService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(RealEstateListingService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
