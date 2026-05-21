package org.author.labauthor.author.model;

import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public record AuthorDTO(UUID id, String firstName, String lastName, Integer age){}

