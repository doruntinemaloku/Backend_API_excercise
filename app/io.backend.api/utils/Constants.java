package io.backend.api.utils;

/**
 * Created by Agon on 10/17/2016.
 */
public class Constants {
    public static final int PAGE_NUMBER = 30;
    public static final int PAGE_NUMBER_LONG = 100;

    public static final String COUNT_KEY = "count";
    public static final String WEIGHTED_AVERAGE_PREFIX = "weightedAverage_";

    public static final String DATE_TIME_DEFAULT_FORMAT = "%Y-%m-%d";
    // Oct 1, 2015 12:00:22 AM
    // 2014-03-03 00:00:00 +0200
    public static final String DATE_TIME_PARSING_FORMAT = "yyyy-MM-dd HH:mm:ss Z";
    public static final String DATE_TIME_CLIENT_FORMAT = "dd-MM-yyyy HH:mm:ss Z";
    public static final String DATE_CLIENT_FORMAT = "dd-MM-yyyy HH:mm:ss";
    public static final String PRESTO_DATE_FORMAT = "yyyy-MM-dd";

    // sort types

    // config types for element
    public static final String CONFIG_TYPE_GROUP_BY = "groupBy";
    public static final String CONFIG_TYPE_METRIC = "metric";

    public static final String CONFIG_METRIC_TYPE = "type";
    public static final String CONFIG_TYPE_SHOW_OTHER = "showOther";
    public static final String CONFIG_TYPE_AVERAGE = "average";
    public static final String CONFIG_TYPE_SHOW_TARGETS = "showTargets";
    public static final String CONFIG_TYPE_TIMELINE = "timeline";
    public static final String CONFIG_TYPE_COMPARE_BY = "compareBy";
    //    public static final String CONFIG_TYPE_SECOND_METRIC = "secondMetric";
    public static final String CONFIG_TYPE_CROSS_CORRELATION = "crossCorrelation";
    public static final String CONFIG_TYPE_JOURNEY_ORDER = "journeyOrder";
    public static final String CONFIG_TYPE_FORMULA = "formulaSelection";

    public static final String ITEM_APPEARANCE = "appearance";
    public static final String ITEM_CONFIG = "config";
    public static final String ITEM_DIEMNSIONS = "dimensions";

    public static final String SELECTION = "selection";
    public static final String TIME_SELECTION = "timeSelection";

    public static final String ITEM_ACTIVE_FILTERS = "filters";
    public static final String ITEM_COMPARE_FILTERS = "compareFilters";
    public static final String DASHBOARD_ACTIVE_FILTERS = "activeFilters";
    public static final String DASHBOARD_COMPARE_FILTERS = "compareFilters";

    // toggle config
    public static final String TOGGLE_ON = "ON";
    public static final String TOGGLE_OFF = "OFF";

    // graph types
    public static final String KPI = "KPI";
    public static final String SCATTER = "Scatter";
    public static final String LINE = "Line";
    public static final String BAR = "Bar";
    public static final String RADAR = "Radar";
    public static final String POLAR = "Polar";
    public static final String PARALLEL = "Parallel";
    public static final String PIE = "Pie";
    public static final String DONUT = "Donut";
    public static final String BOUBLE = "Bouble";
    public static final String JOURNEY_OVERVIEW = "JourneyOverview";
    public static final String SANKEY = "Sankey";
    public static final String JOURNEY = "Journey";
    public static final String DATA_EXPLORE = "Explorer";
    public static final String TWO_DIMENSIONAL_BAR_CHART = "TwoDBar";
    public static final String GANTT_CHART = "GanttChart";
    public static final String CROSS_HEAT_MAP = "HeatMap";
    public static final String HEAT_MAP = "TwoHeatMap";
    public static final String CUSTOM_CODE = "CustomCodeWidget";
    public static final String BOX_PLOT = "BoxPlot";
    public static final String CHAT = "Chat";
    public static final String GAUGE = "Gauge";
    public static final String NOTE = "Note";
    public static final String TREE = "Tree";
    public static final String MAP = "Map";
    public static final String WATERFALL = "Waterfall";
    public static final String METRIC_COMPARE = "MetricCompare";
    public static final String STACKED_BAR = "StackedBar";
    public static final String TABLE = "Table";

    public static final String DISPLAY_TYPE = "displayType";
    public static final String VARIABLE_TYPE = "variableType";
    // display types
    // filter types
    public static final String LIST = "LIST";
    public static final String DRAG_DROP = "DRAG_DROP";
    public static final String TIME = "TIME";
    public static final String TIMESTAMP = "TIMESTAMP";
    public static final String NUMERICAL = "NUMERICAL";

    // channel types
    public static final String DIRECT = "DIRECT";
    public static final String PUBLIC = "PUBLIC";
    public static final String GROUP = "GROUP";

    // formula types
    public static final String FORMULA_TYPES_WEIGHTED_AVERAGE = "WEIGHTED_AVERAGE";
    public static final String STANDARD_DEVIATION = "STANDARD_DEVIATION";
    public static final String AVERAGE = "AVERAGE";
    public static final String PERCENTAGE = "PERCENTAGE";

    // variable types
    public static final String GEO_REFERENCE = "GEO_REFERENCE";
    public static final String CROSS_RELATIONSHIP = "CROSS_RELATIONSHIP";
    public static final String JOURNEY_ORDER = "JOURNEY_ORDER";

    // database config type
    public static final String DB_CONFIG_TYPE_FILTER = "filter";
    public static final String DB_CONFIG_TYPE_VARIABLE = "variable";
    public static final String DB_CONFIG_TYPE_METRIC = "metric";

    // batch size on mongo query
    public static final int BATCH_SIZE = 10000;

}
