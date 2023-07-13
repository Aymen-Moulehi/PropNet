import { TestBed } from '@angular/core/testing';

import { GovernorateService } from './governorate.service';

describe('GovernorateService', () => {
  let service: GovernorateService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(GovernorateService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
