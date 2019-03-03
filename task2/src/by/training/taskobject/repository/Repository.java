package by.training.taskobject.repository;

import by.training.taskobject.entity.Ellipse;
import by.training.taskobject.recorder.EllipseData;
import by.training.taskobject.specification.EllipseSpecification;
import by.training.taskobject.specification.FindEllipseSpecification;

import java.util.List;


public interface Repository {

   void addEllipse(Ellipse ellipse, EllipseData ellipseData);
   void removeEllipse(FindEllipseSpecification specification);
   void updateEllipse(FindEllipseSpecification specification);

   List query(EllipseSpecification specification);
}
