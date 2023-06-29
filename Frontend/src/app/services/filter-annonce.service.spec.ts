import { TestBed } from '@angular/core/testing';

import { FilterAnnonceService } from './filter-annonce.service';

describe('FilterAnnonceService', () => {
  let service: FilterAnnonceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(FilterAnnonceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
