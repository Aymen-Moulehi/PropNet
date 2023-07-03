import { TestBed } from '@angular/core/testing';

import { UpdateAccountService } from './update-account.service';

describe('UpdateAccountService', () => {
  let service: UpdateAccountService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(UpdateAccountService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy(
