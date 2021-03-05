import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SeirdsComponentComponent } from './seirds-component.component';

describe('SeirdsComponentComponent', () => {
  let component: SeirdsComponentComponent;
  let fixture: ComponentFixture<SeirdsComponentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SeirdsComponentComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SeirdsComponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
