package org.rygn.kanban.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;

import java.util.Collection;

import org.rygn.kanban.utils.Constants;
import org.rygn.kanban.domain.Task;
import org.rygn.kanban.domain.TaskStatus;
import org.rygn.kanban.domain.TaskType;
import org.rygn.kanban.service.TaskService;
import org.rygn.kanban.utils.TaskMoveAction;

@RestController
public class TaskController {
	
	@Autowired
	private TaskService taskService;
	
	@GetMapping("/task")
	Collection<Task> findAllTasks(){
		return this.taskService.findAllTasks();
	}
	
	@PostMapping("/tasks")
	Task createTask( @RequestBody Task task) {
		return this.taskService.createTask(task);
	}
	@PatchMapping("/tasks/{id}")
	 public Task moveTask(@RequestBody TaskMoveAction taskMoveAction, @PathVariable Long id) {
		Task task = this.taskService.findTask(id);
		if (Constants.MOVE_LEFT_ACTION.equals(taskMoveAction.getAction())) {
			task = this.taskService.moveLeftTask(task);
		}
		else if (Constants.MOVE_RIGHT_ACTION.equals(taskMoveAction.getAction())) {
			task = this.taskService.moveRightTask(task);
		}
		else {
			throw new IllegalStateException();
		}
		return task;
	}
	
	

}
