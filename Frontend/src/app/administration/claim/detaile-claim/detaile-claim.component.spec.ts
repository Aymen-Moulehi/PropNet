import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DetaileClaimComponent } from './detaile-claim.component';

describe('DetaileClaimComponent', () => {
  let component: DetaileClaimComponent;
  let fixture: ComponentFixture<DetaileClaimComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DetaileClaimComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DetaileClaimComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
