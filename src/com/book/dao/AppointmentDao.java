package com.book.dao;

import java.util.List;

import com.book.entity.Appointment;

public interface AppointmentDao {
    public int insertAppoint(int bookId,int studentId);
    public List<Appointment> queryAndReturn(int studentId);
}
