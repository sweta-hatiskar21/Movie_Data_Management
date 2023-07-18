package com.movie.data.constant;

public class MoviesQueryConstant {

	//public static final String SQL_TO_SELECT_MOVIES="SELECT a.nconst, a.primaryName, a.birthYear, a.deathYear, a.primaryProfession, json_arrayagg(json_object('m.tconst',' m.titleType', 'm.primaryTitle', 'm.originalTitle', 'm.isAdult', 'm.startYear', 'm.endYear', 'm.runtimeMinutes', 'm.genres', 't.category', 't.job', 't.characters'))as movies FROM actors_name as a inner join movie_data as m on find_in_set(m.tconst,a.knownForTitles)>0 inner join titles_mapping as t on t.nconst=a.nconst group by a.nconst,a.primaryName and a.primaryName=?";

	//public static final String SQL_TO_SELECT_MOVIES="SELECT a.nconst, a.primaryName, a.birthYear, a.deathYear, a.primaryProfession, json_arrayagg(json_object('m.tconst',m.tconst,'m.titleType',m.titleType, 'm.primaryTitle',m.primaryTitle, 'm.originalTitle',m.originalTitle,'m.isAdult', m.isAdult, 'm.startYear',m.startYear,'m.endYear', m.endYear, 'm.runtimeMinutes',m.runtimeMinutes, 'm.genres',m.genres,'t.category', t.category,'t.job', t.job, 't.characters',t.characters))as movies FROM actors_name as a inner join movie_data as m on find_in_set(m.tconst,a.knownForTitles)>0 inner join titles_mapping as t on t.nconst=a.nconst group by a.nconst,a.primaryName and a.primaryName=?";

	//public static final String SQL_TO_SELECT_MOVIES="SELECT a.nconst, a.primaryName, a.birthYear, a.deathYear, a.primaryProfession, group_concat(concat(ifnull(m.tconst,'null'),':',ifnull(m.titleType,'null'),':', ifnull(m.primaryTitle,'null'),':',ifnull( m.originalTitle,'null'),':', ifnull(m.isAdult,'null'),':',ifnull( m.startYear,'null'),':', ifnull(m.endYear,'null'),':', ifnull(m.runtimeMinutes,'null'),':', ifnull(m.genres,'null'),':', ifnull(t.category,'null'),':',ifnull( t.job,'null'),':', ifnull(t.characters,'null'))separator',') as movies FROM actors_name as a inner join movie_data as m on find_in_set(m.tconst,a.knownForTitles)>0 inner join titles_mapping as t on t.nconst=a.nconst group by a.nconst,a.primaryName=?";

	public static final String SQL_TO_SELECT_MOVIES="SELECT nconst, primaryName, birthYear, deathYear, primaryProfession,knownForTitles from actors_name where primaryName=?";

	public static String SQL_TO_SELECT_MOVIES2="select m.tconst, m.titleType, m.primaryTitle, m.originalTitle, m.isAdult, m.startYear, m.endYear, m.runtimeMinutes, m.genres, t.category, t.job, t.characters FROM movie_data as m inner join titles_mapping as t on t.nconst=? where m.tconst in(";
}
