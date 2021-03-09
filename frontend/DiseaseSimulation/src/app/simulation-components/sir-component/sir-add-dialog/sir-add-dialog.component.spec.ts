import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SirAddDialogComponent } from './sir-add-dialog.component';

describe('SirAddDialogComponent', () => {
  let component: SirAddDialogComponent;
  let fixture: ComponentFixture<SirAddDialogComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SirAddDialogComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SirAddDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
