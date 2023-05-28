package com.example.ajoutayo.dto.response;


import com.example.ajoutayo.domain.BusRoute;
import com.example.ajoutayo.domain.BusStop;
import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BusRouteResponseDto {
    private long busRouteId;
    private String type;
    private String departmentTimeList;
    private BusStop depBusStop;
    private BusStop midBusStop;
    private BusStop  arrBusStop;
    public BusRouteResponseDto(BusRoute entity){
        this.busRouteId= entity.getId();
        this.type=entity.getType();
        this.departmentTimeList= entity.getDepartmentTimeList();
        this.arrBusStop=entity.getArrBusStop();
        this.midBusStop=entity.getMidBusStop();
        this.depBusStop=entity.getDepBusStop();

    }
}
