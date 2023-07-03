import { TestBed } from '@angular/core/testing';

import { RestepasswordService } from './restepassword.service';

describe('RestepasswordService', () => {
  let service: RestepasswordService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(RestepasswordService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
