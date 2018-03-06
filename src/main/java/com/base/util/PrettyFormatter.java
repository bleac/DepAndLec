package com.base.util;

import com.base.dbworker.DataBaseWorker;
import com.base.entity.Degree;
import com.base.entity.Department;
import com.base.entity.Lector;
import lombok.Data;

import javax.jws.Oneway;
import java.util.List;

public class PrettyFormatter {

    public static String extractPrettyNamesForLectors(List<Lector> lectors) {
        final String[] result = {""};
        if (lectors.isEmpty()) {
            result[0] = "Not found! Try another parameters.";
        } else {
            lectors.forEach(lector -> result[0] += "\n" + lector.getFirstName() + " " + lector.getLastName());
        }
        return result[0];
    }

    public static String extractNameOfDepAndHeadMaster(Department department) {
        Lector lector = department.getLectors().get(0);
        return "Head of " + department.getName() + " department is " + lector.getLastName() + " " + lector.getFirstName() + ".";
    }

    public static String provideStatisticByDegree(List<Object> results) {
        for (Object o : results)  {
            ResultModel model = (ResultModel)o;
        }
        return null;
    }

    @Data
    private static class ResultModel {
        private Degree degree;
        private long count;
    }
}
