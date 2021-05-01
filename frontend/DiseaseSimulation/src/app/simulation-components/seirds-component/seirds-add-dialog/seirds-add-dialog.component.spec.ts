import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SeirdsAddDialogComponent } from './seirds-add-dialog.component';

describe('SeirdsAddDialogComponent', () => {
  let component: SeirdsAddDialogComponent;
  let fixture: ComponentFixture<SeirdsAddDialogComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SeirdsAddDialogComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SeirdsAddDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
