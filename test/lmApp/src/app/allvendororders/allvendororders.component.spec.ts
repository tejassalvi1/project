import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AllvendorordersComponent } from './allvendororders.component';

describe('AllvendorordersComponent', () => {
  let component: AllvendorordersComponent;
  let fixture: ComponentFixture<AllvendorordersComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AllvendorordersComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AllvendorordersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
