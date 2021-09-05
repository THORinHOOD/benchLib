package com.db.benchLib.data.bench;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;


@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class BenchInfoWithDistance extends BenchDto {
    private double distance;
}
