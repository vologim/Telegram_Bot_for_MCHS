package com.golovackii.mchs_tg_bot.repository;

import com.golovackii.mchs_tg_bot.model.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule, Integer> {
}
