/*
 * Sonar Scoverage Plugin
 * Copyright (C) 2013 Rado Buransky
 * dev@sonar.codehaus.org
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02
 */
package com.buransky.plugins.scoverage.util

import java.io.File
/**
 *  File path helper.
 *
 * @author Rado Buransky
 */
object PathUtil {
  def splitPath(filePath: String, separator: String = File.separator): List[String] = {
    val file = new File(filePath)
    if (file.isAbsolute && file.exists()) {
      val path = splitFilePath(filePath, separator).filter(_ != "")
      path.update(0, File.separator + path.head)
      path.toList
    } else if (filePath.startsWith("/")) {
      splitFilePath(filePath, separator).toList.drop(1)
    } else {
      splitFilePath(filePath, separator).toList
    }
  }

  private def splitFilePath(filePath: String, separator: String): Array[String] = {
    filePath.split(separator.replaceAllLiterally("\\", "\\\\"))
  }
}
