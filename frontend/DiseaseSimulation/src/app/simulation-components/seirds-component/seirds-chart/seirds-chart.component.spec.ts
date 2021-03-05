import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SeirdsChartComponent } from './seirds-chart.component';

describe('SeirdsChartComponent', () => {
  let component: SeirdsChartComponent;
  let fixture: ComponentFixture<SeirdsChartComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SeirdsChartComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SeirdsChartComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
