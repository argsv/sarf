import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ConjugationLabelComponent } from './conjugation-label.component';

describe('ConjugationLabelComponent', () => {
  let component: ConjugationLabelComponent;
  let fixture: ComponentFixture<ConjugationLabelComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ConjugationLabelComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ConjugationLabelComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});