package by.training.taskobject.repository;

import by.training.taskobject.entity.Ellipse;
import by.training.taskobject.recorder.EllipseData;
import by.training.taskobject.specification.EllipseSpecification;
import by.training.taskobject.specification.FindEllipseSpecification;
import by.training.taskobject.specification.FindEllipseSpecificationByEllipseData;
import by.training.taskobject.specification.SortEllipseSpecification;

import java.util.ArrayList;
import java.util.List;

public class EllipseRepository implements Repository {

    private List<Ellipse> ellipseList = new ArrayList<>();
    private List<EllipseData> ellipseDataList = new ArrayList<>();

    private EllipseRepository() { }

    private static class RepositoryHolder {
        private static final  EllipseRepository INSTANCE =
                new EllipseRepository();
    }

    public static EllipseRepository getInstance() {
        return RepositoryHolder.INSTANCE;
    }

    @Override
    public void addEllipse(final Ellipse ellipse,
                           final EllipseData ellipseData) {

        ellipseList.add(ellipse);
        ellipseDataList.add(ellipseData);
    }

    @Override
    public void removeEllipse(final FindEllipseSpecification specification) {

            for (Ellipse ellipse : ellipseList) {

                if (specification.specified(ellipse)) {
                    ellipseList.remove(ellipse.getId());
                    ellipseDataList.remove(ellipse.getId());
                }
            }
    }

    @Override
    public void updateEllipse(final FindEllipseSpecification specification) {

            for (Ellipse ellipse : ellipseList) {

                if (specification.specified(ellipse)) {
                    ellipseList.set(ellipse.getId(), ellipse);
                    EllipseData ellipseData = new EllipseData();
                    ellipseData.updateEllipseData(ellipse);
                    ellipseDataList.set(ellipse.getId(), ellipseData);
                }
            }

    }

    @Override
    public List<Ellipse> query(final EllipseSpecification specification) {

        List<Ellipse> queryEllipseList = new ArrayList<>();

        if (specification instanceof FindEllipseSpecification) {

            for (Ellipse ellipse : ellipseList) {

                if (((FindEllipseSpecification) specification)
                        .specified(ellipse)) {
                    queryEllipseList.add(ellipse);
                }
            }
        } else if (specification instanceof
                FindEllipseSpecificationByEllipseData) {

                for (int i = 0; i < ellipseDataList.size(); i++) {

                    if (((FindEllipseSpecificationByEllipseData) specification)
                            .specified(ellipseDataList.get(i))) {
                        queryEllipseList.add(ellipseList.get(i));
                    }
                }
        } else if (specification instanceof SortEllipseSpecification) {

            queryEllipseList.sort(((SortEllipseSpecification) specification)
                    .specifiedComparator());
        }

        return queryEllipseList;
    }
}
